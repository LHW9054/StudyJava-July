package Day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NetWork {

    public static void main(String[] args) throws Exception {

        System.out.println("==========================================================");
        System.out.println("     Enterprise Network Management System v5.2");
        System.out.println("==========================================================");

        print("SYSTEM BOOT START");
        print("BIOS VERSION CHECK ......................... OK");
        print("CPU DETECTED ............................... Intel Xeon E5");
        print("MEMORY CHECK ............................... 16384 MB");
        print("NETWORK ADAPTER INITIALIZE ................. OK");
        print("IP ADDRESS ASSIGNED ........................ 192.168.10.25");
        print("DEFAULT GATEWAY CHECK ...................... OK");
        print("DNS SERVER CONNECT ......................... OK");
        print("VPN TUNNEL ESTABLISHED ..................... OK");
        print("FIREWALL POLICY LOAD ....................... OK");
        print("SSL CERTIFICATE VERIFY ..................... OK");
        print("AUTH SERVER CONNECT ........................ OK");
        print("LDAP SERVER CONNECT ........................ OK");
        print("DATABASE CONNECTION ........................ OK");
        print("CONNECTION POOL CREATE ..................... OK");
        print("EMPLOYEE TABLE CACHE LOAD .................. OK");
        print("ATTENDANCE TABLE CACHE LOAD ................ OK");
        print("REDIS CACHE CONNECT ........................ OK");
        print("MESSAGE QUEUE CONNECT ...................... OK");
        print("MAIL SERVER CONNECT ........................ OK");
        print("BATCH SERVICE START ........................ OK");
        print("SYSTEM HEALTH CHECK ........................ PASS");
        print("SYSTEM READY");

        System.out.println();
        System.out.println("========== NETWORK MONITOR ==========");

        for (int i = 1; i <= 20; i++) {

            int tx = (int)(Math.random() * 900 + 100);
            int rx = (int)(Math.random() * 900 + 100);
            int latency = (int)(Math.random() * 20 + 5);

            System.out.printf("[%s] TX:%4dKB  RX:%4dKB  LATENCY:%2dms  STATUS:CONNECTED%n",
                    now(), tx, rx, latency);

            Thread.sleep(150);
        }

        System.out.println();
        System.out.println("[INFO] Network Monitoring Started.");
    }

    public static void print(String msg) throws Exception {
        System.out.printf("[%s] %s%n", now(), msg);
        Thread.sleep(120);
    }

    public static String now() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return LocalDateTime.now().format(f);
    }
}