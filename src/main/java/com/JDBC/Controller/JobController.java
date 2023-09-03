package com.JDBC.Controller;

import system.DB.DBClose;
import system.DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JobController {
    Connection conn = null;
    PreparedStatement stmt = null;

    Scanner sc = new Scanner(System.in);

    int id;
    String name;
    String job;
    String exp;
    public void Search() {
        System.out.println("직업을 조회할 사원번호를 입력하세요");
        id = sc.nextInt();

        try {
            conn = DBConnection.getConnection();

            String sql = "select JOB from employ where id = $(id)";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(stmt, conn);
        }
    }

    public void write() {
        System.out.println("직업을 추가할 사원번호를 입력하세요");
        id = sc.nextInt();

        try {
            conn = DBConnection.getConnection();

            String sql = "update employ set JOB= '' where id = $(id)";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(stmt, conn);
        }
    }

    public void Delete() {
        System.out.println("직업을 삭제할 사원번호를 입력하세요");
        id = sc.nextInt();

        try {
            conn = DBConnection.getConnection();

            String sql = "delete JOB from employ where id = $(id)";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(stmt, conn);
        }
    }
}
