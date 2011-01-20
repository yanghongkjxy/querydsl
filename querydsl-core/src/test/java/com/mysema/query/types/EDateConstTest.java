/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.types;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

import com.mysema.query.types.expr.EDate;
import com.mysema.query.types.expr.EDateConst;

public class EDateConstTest {

    @Test
    public void test(){
        // 1.1.2000
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.YEAR,  2000);
        System.out.println(cal.getTime());

        EDate<Date> date = EDateConst.create(new Date(cal.getTimeInMillis()));
        assertEquals("1",   date.dayOfMonth().toString());
        assertEquals("1",   date.month().toString());
        assertEquals("2000",date.year().toString());
        assertEquals("7", date.dayOfWeek().toString());
        assertEquals("1", date.dayOfYear().toString());
    }

}