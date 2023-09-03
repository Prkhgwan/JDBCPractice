package com.JDBC.Controller;

import com.JDBC.UI.UI;

import java.util.Scanner;

public class Controller {
    public void start() {
        CareerController Ccon = new CareerController();
        PeopleController Pcon = new PeopleController();
        JobController Jcon = new JobController();
        UI v = new UI();

        Scanner scanner = new Scanner(System.in);

        v.title();
        v.version();
        while (true) {
            v.mainUI();
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "인원추가":
                    Pcon.Write();
                    break;
                case "인원조회":
                    Pcon.Search();
                    break;
                case "인원삭제":
                    Pcon.Delete();
                    break;
                case "인원수정":
                    Pcon.Update();
                    break;
                case "직업조회":
                    Jcon.Search();
                    break;
                case "직업추가":
                    Jcon.write();
                    break;
                case "직업삭제":
                    Jcon.Delete();
                    break;
                case "경력조회":
                    Ccon.Search();
                    break;
                case "경력추가":
                    Ccon.Write();
                    break;
                case "경력삭제":
                    Ccon.Delete();
                    break;
                case "경력수정":
                    Ccon.Update();
                    break;
                case "종료":
                    System.exit(0);
            }
        }
    }
}