/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author b15-20m
 */
public class Metodos {
    public static Date convertirDate(String str){
        Date date = null;
        try{
            date = new SimpleDateFormat("dd/mm/yyy").parse(str);
        }catch(ParseException e){
            System.out.println(e);
        }
        return date;
    }
}
