package com.xiaofeng.mybatisplus3_1.springbootmybatisplus3_1;
import com.google.common.collect.Lists;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class IPWhitelistValidator {

    /**
     * 验证IP地址是否在白名单中（支持单个IP和CIDR网段）
     * @param ipToCheck 待验证的IP地址
     * @param whitelist 白名单列表
     * @return 是否通过验证
     */
    public boolean isIPAllowed(String ipToCheck, List<String> whitelist) {
        try {
            InetAddress checkIP = InetAddress.getByName(ipToCheck);

            for (String whitelistEntry : whitelist) {
                if (isIPInWhitelist(checkIP, whitelistEntry)) {
                    return true;
                }
            }
            return false;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    /**
     * 判断IP是否在白名单项中
     * @param checkIP 待检查的IP地址
     * @param whitelistEntry 白名单项（可以是单个IP或CIDR网段）
     * @return 是否匹配
     */
    private boolean isIPInWhitelist(InetAddress checkIP, String whitelistEntry) {
        try {
            // 判断是否为CIDR网段格式 (例如: 192.168.1.0/24)
            if (whitelistEntry.contains("/")) {
                return isIPInCIDR(checkIP, whitelistEntry);
            } else {
                // 单个IP地址匹配
                InetAddress whitelistIP = InetAddress.getByName(whitelistEntry);
                return checkIP.equals(whitelistIP);
            }
        } catch (UnknownHostException e) {
            return false;
        }
    }

    /**
     * 判断IP是否在CIDR网段内
     * @param checkIP 待检查的IP地址
     * @param cidr CIDR格式的网段 (例如: 192.168.1.0/24)
     * @return 是否在网段内
     */
    private boolean isIPInCIDR(InetAddress checkIP, String cidr) {
        try {
            String[] parts = cidr.split("/");
            InetAddress networkIP = InetAddress.getByName(parts[0]);
            int prefixLength = Integer.parseInt(parts[1]);

            // IPv4处理
            if (checkIP.getAddress().length == 4 && networkIP.getAddress().length == 4) {
                return isIPInIPv4CIDR(checkIP, networkIP, prefixLength);
            }
            // IPv6处理
            else if (checkIP.getAddress().length == 16 && networkIP.getAddress().length == 16) {
                return isIPInIPv6CIDR(checkIP, networkIP, prefixLength);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * IPv4 CIDR网段检查
     */
    private boolean isIPInIPv4CIDR(InetAddress checkIP, InetAddress networkIP, int prefixLength) {
        if (prefixLength < 0 || prefixLength > 32) return false;

        byte[] checkBytes = checkIP.getAddress();
        byte[] networkBytes = networkIP.getAddress();

        int mask = ~((1 << (32 - prefixLength)) - 1);
        int checkIPInt = ((checkBytes[0] & 0xFF) << 24) | ((checkBytes[1] & 0xFF) << 16) |
                ((checkBytes[2] & 0xFF) << 8) | (checkBytes[3] & 0xFF);
        int networkIPInt = ((networkBytes[0] & 0xFF) << 24) | ((networkBytes[1] & 0xFF) << 16) |
                ((networkBytes[2] & 0xFF) << 8) | (networkBytes[3] & 0xFF);

        return (checkIPInt & mask) == (networkIPInt & mask);
    }

    /**
     * IPv6 CIDR网段检查
     */
    private boolean isIPInIPv6CIDR(InetAddress checkIP, InetAddress networkIP, int prefixLength) {
        if (prefixLength < 0 || prefixLength > 128) return false;

        byte[] checkBytes = checkIP.getAddress();
        byte[] networkBytes = networkIP.getAddress();

        int fullBytes = prefixLength / 8;
        int remainingBits = prefixLength % 8;

        // 检查完整的字节
        for (int i = 0; i < fullBytes; i++) {
            if (checkBytes[i] != networkBytes[i]) {
                return false;
            }
        }

        // 检查剩余的位
        if (remainingBits > 0) {
            int mask = 0xFF << (8 - remainingBits);
            return (checkBytes[fullBytes] & mask) == (networkBytes[fullBytes] & mask);
        }

        return true;
    }


    public static void main(String[] args) {
        IPWhitelistValidator validator = new IPWhitelistValidator();

        // 白名单列表，支持单个IP和CIDR网段
        List<String> whitelist = Arrays.asList(
                "192.168.1.100",        // 单个IP
                "10.0.0.0/8",           // 10.0.0.0到10.255.255.255网段
                "172.16.0.0/12",        // 172.16.0.0到172.31.255.255网段
                "192.168.0.0/16",       // 192.168.0.0到192.168.255.255网段
                "2001:db8::/32",         // IPv6网段示例
                "172.17.99.0/24"         // IPv6网段示例
        );

        // 测试IP验证
        System.out.println(validator.isIPAllowed("192.168.1.100", whitelist)); // true
        System.out.println(validator.isIPAllowed("10.1.2.3", whitelist));      // true
        System.out.println(validator.isIPAllowed("172.16.1.1", whitelist));    // true
        System.out.println(validator.isIPAllowed("8.8.8.8", whitelist));       // false
        System.out.println(validator.isIPAllowed("172.17.99.1", whitelist));       // true
    }
}
