package com.mine.file

import static org.apache.commons.csv.CSVFormat.RFC4180 
import groovy.sql.Sql
import org.postgresql.Driver 
// get csv file

class ReadCsv
{
    static readfile(path)
    {
        def file = new File(path)
        def header = RFC4180.withHeader()
                    .parse(file.newReader())
                    .getHeaderMap().keySet()
        def row = RFC4180.withHeader().parse(file.newReader()).iterator()
        return row
    }
}

