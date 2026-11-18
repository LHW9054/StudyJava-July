package Day01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Test1 {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        printBootLog();

        while (true) {

            System.out.println();
            System.out.println("===============================================");
            System.out.println("         社員情報統合管理システム V3.4");
            System.out.println("===============================================");
            System.out.println("1. 社員登録");
            System.out.println("2. 社員検索");
            System.out.println("3. 勤怠情報確認");
            System.out.println("4. システムログ確認");
            System.out.println("5. DB同期実行");
            System.out.println("0. システム終了");
            System.out.println("===============================================");
            System.out.print("メニューを選択してください : ");

            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    registerEmployee();
                    break;
                case "2":
                    searchEmployee();
                    break;
                case "3":
                    attendanceInfo();
                    break;
                case "4":
                    systemLog();
                    break;
                case "5":
                    syncDatabase();
                    break;
                case "0":
                    shutdown();
                    return;
                default:
                    System.out.println("[ERROR] 存在しないメニューです。");
            }
        }
    }

    public static void printBootLog() {

        System.out.println("------------------------------------------------");
        System.out.println("SYSTEM BOOT START");
        System.out.println("OS VERSION CHECK ............ OK");
        System.out.println("NETWORK INITIALIZE .......... OK");
        System.out.println("SECURITY MODULE LOAD ........ OK");
        System.out.println("DB CONNECTION CHECK ......... OK");
        System.out.println("CACHE SERVER CHECK .......... OK");
        System.out.println("USER AUTH MODULE LOAD ....... OK");
        System.out.println("BATCH SERVICE START ......... OK");
        System.out.println("SYSTEM START TIME : " + now());
        System.out.println("------------------------------------------------");
    }

    public static void registerEmployee() {

        System.out.println();
        System.out.println("========== 社員登録 ==========");

        String empNo;

        while (true) {
            System.out.print("社員番号(6桁) : ");
            empNo = sc.nextLine();

            if (empNo.matches("\\d{6}")) {
                break;
            }

            System.out.println("[ERROR] 数字6桁で入力してください。");
        }

        System.out.print("社員名 : ");
        String name = sc.nextLine();

        System.out.print("部署名 : ");
        String dept = sc.nextLine();

        System.out.print("メールアドレス : ");
        String mail = sc.nextLine();

        System.out.println();
        System.out.println("[INFO] 入力データ検証中...");
        fakeLoading();

        System.out.println("[INFO] 重複社員番号チェック...");
        fakeLoading();

        System.out.println("[INFO] 社員テーブル登録中...");
        fakeLoading();

        System.out.println("[INFO] 権限テーブル登録中...");
        fakeLoading();

        System.out.println("[INFO] メールアカウント生成中...");
        fakeLoading();

        System.out.println("-----------------------------------");
        System.out.println("社員番号 : " + empNo);
        System.out.println("社員名   : " + name);
        System.out.println("部署名   : " + dept);
        System.out.println("メール   : " + mail);
        System.out.println("-----------------------------------");
        System.out.println("[SUCCESS] 社員登録完了");
        System.out.println("登録日時 : " + now());
    }

    public static void searchEmployee() {

        System.out.println();
        System.out.println("========== 社員検索 ==========");
        System.out.print("検索する社員番号 : ");

        String no = sc.nextLine();

        System.out.println("[INFO] DATABASE QUERY START");
        fakeLoading();

        System.out.println("社員番号 : " + no);
        System.out.println("氏名 : 山田 太郎");
        System.out.println("部署 : システム開発部");
        System.out.println("入社日 : 2022/04/01");
        System.out.println("状態 : 在職中");
        System.out.println("[INFO] QUERY SUCCESS");
    }

    public static void attendanceInfo() {

        System.out.println();
        System.out.println("========== 勤怠情報 ==========");
        System.out.println("出勤日数 : 19日");
        System.out.println("欠勤日数 : 0日");
        System.out.println("残業時間 : 14時間");
        System.out.println("有給残数 : 8日");

        System.out.println();
        System.out.println("[INFO] ATTENDANCE DATA LOAD COMPLETE");
    }

    public static void systemLog() {

        System.out.println();
        System.out.println("========== SYSTEM LOG ==========");

        for (int i = 1; i <= 20; i++) {
            System.out.println(
                    "[" + now() + "] INFO - Transaction ID : TX"
                            + (100000 + random.nextInt(900000))
                            + " Process Complete");
        }
    }

    public static void syncDatabase() {

        System.out.println();
        System.out.println("========== DB同期 ==========");

        System.out.println("[INFO] Database Connection Open");
        fakeLoading();

        System.out.println("[INFO] Employee Table Sync...");
        fakeLoading();

        System.out.println("[INFO] Attendance Table Sync...");
        fakeLoading();

        System.out.println("[INFO] Department Table Sync...");
        fakeLoading();

        System.out.println("[INFO] Cache Refresh...");
        fakeLoading();

        System.out.println("[SUCCESS] Database Synchronization Complete");
    }

    public static void shutdown() {

        System.out.println();
        System.out.println("[INFO] Session Closing...");
        System.out.println("[INFO] Cache Release...");
        System.out.println("[INFO] Connection Close...");
        System.out.println("[INFO] System Shutdown Complete");
    }

    public static void fakeLoading() {

        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "[" + now() + "] PROCESS STEP "
                            + (i + 1)
                            + " COMPLETED.");
        }
    }

    public static String now() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return LocalDateTime.now().format(formatter);
    }
}