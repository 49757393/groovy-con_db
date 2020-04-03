package com.mine.db

//import packages
//import java.io.File 

// use @Grab() to download CSV package
//@Grab('org.apache.commons:commons-csv:1.2') 
import groovy.sql.Sql
import org.postgresql.Driver
import com.mine.bean.*


class Db
{
    static getDb()
    {
        def db = Sql.newInstance(   
        "jdbc:postgresql://127.0.0.1:5432/exampledb",   
        "yangliang",   
        "123456",   
        "org.postgresql.Driver")  
        return db 
    }
    static insertDb(row)
    {
        def db = getDb()
        row.each { 
        def cols = it.values
        def tran_date =  "'" + cols[0] + "'"
        def timestampl = cols[1] 
        def acc =  cols[2] 
        def amt = cols[3]
        def dr_cr_flag = cols[4]
        def rpt_sum = cols[5] 
        db.execute("INSERT INTO brch_qry_dtl (tran_date , timestampl , acc , amt , dr_cr_flag , rpt_sum) VALUES (cast(${tran_date} as date),${timestampl}, ${acc}, cast(${amt} as numeric), cast(${dr_cr_flag} as integer), ${rpt_sum})");
        }
    }
    static selectDb_01()
    {
        def db = getDb()
        def result = []
        def row = [:]
        db.eachRow("select * from brch_qry_dtl"){
            row['tran_date'] = it.tran_date
            row['timestampl'] = it.timestampl
            row['acc'] = it.acc
            row['amt'] = it.amt
            row['dr_cr_flag'] = it.dr_cr_flag
            row['rpt_sum'] = it.rpt_sum
            //println row
            result.add(row)
        }
        return result
    }
    static selectDb_02()
    {
        def db = getDb()
        def result = []
        def dtl = new BrchBean()
        db.eachRow("select * from brch_qry_dtl"){
            dtl.tran_date = it.tran_date
            dtl.timestampl = it.timestampl
            dtl.acc = it.acc
            dtl.amt = it.amt
            dtl.dr_cr_flag = it.dr_cr_flag
            dtl.rpt_sum = it.rpt_sum
            
            result.add(dtl)
        }
        return result
    }
    
}