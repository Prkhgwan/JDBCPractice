package com.JDBC.Controller;

import system.DB.DBClose;
import system.DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PeopleController {
    Connection conn = null;
    PreparedStatement stmt = null;

    Scanner sc = new Scanner(System.in);

    int id;
    String name;
    String job;
    String exp;
    public void Write() {


        System.out.println("이름을 입력하세요");
        name = sc.nextLine();
        System.out.println("직업을 입력하세요");
        job = sc.nextLine();
        System.out.println("직업을 입력하세요");
        exp = sc.nextLine();

        try {
            conn = DBConnection.getConnection();

            String sql = "insert into employ values(?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1,name);
            stmt.setString(2,job);
            stmt.setString(3,exp);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(stmt, conn);
        }
    }

    public void Search() {
        System.out.println("찾으실 사원명을 입력하세요");
        name = sc.nextLine();

        try {
            conn = DBConnection.getConnection();

            String sql = "select * from employ where NAME = $(name)";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(stmt, conn);
        }
    }

    public void Delete() {
        System.out.println("삭제할 사원번호를 입력하세요");
        id = sc.nextInt();
        try {
                conn = DBConnection.getConnection();

                String sql = "delete from employ where id = $(id)";
                stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        System.out.println("수정할 사원번호를 입력하세요");
        id = sc.nextInt();
        try {
            conn = DBConnection.getConnection();
            String sql = "update employ (?, ?, ?) where id = $(id)";
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
