package com.labo.code.ace.oei.db;

import android.support.test.runner.AndroidJUnit4;

import com.labo.code.ace.oei.vo.AnswerVO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by Chui Eng on 17/4/2017.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    private DatabaseHelper database;
    private static String DB_NAME = "familyTree.db";

    @Before
    public void setUp() throws Exception {
        database = new DatabaseHelper(getTargetContext());
        database.createDataBase();
        database.openDataBase();
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }

    @Test
    public void shouldGetFirstDropDownList() throws Exception {
        List<String> result = database.queryFirstDropdownList("M");
        assertThat(result.size(), is(10));//1 record is dropdownList.add("选择一项");
    }


    @Test
    public void shouldGetSecondDropDownList() throws Exception {
        List<String> result = database.querySecondDropdownList("M", "爸爸");
        assertThat(result.size(), is(7));//1 record is dropdownList.add("选择一项");
    }


    @Test
    public void shouldGetThirdDropDownList() throws Exception {
        List<String> result = database.queryThirdDropdownList("M", "爸爸", "哥哥");
        assertThat(result.size(), is(4));//1 record is dropdownList.add("选择一项");
    }


    @Test
    public void shouldGetFourthDropDownList() throws Exception {
        List<String> result = database.queryFourthDropdownList("M", "爸爸", "哥哥", "儿子");
        assertThat(result.size(), is(4));//1 record is dropdownList.add("选择一项");
    }

    @Test
    public void shouldQueryAnswer() throws Exception {
        AnswerVO result = database.queryAnswer("M", "爸爸", "弟弟", "儿子", "老婆");
        assertEquals("堂嫂/堂弟媳", result.getAnswer());
        assertEquals("F", result.getGender());
        assertNull(result.getOldInd());
    }

    @Test
    public void shouldQueryAnswer2() throws Exception {
        AnswerVO result = database.queryAnswer("M", "儿子", "儿子", "儿子", "选择一项");
        assertEquals("曾孙子", result.getAnswer());
        assertEquals("M", result.getGender());
        assertFalse(result.getOldInd());
    }

    @Test
    public void shouldQueryAnswer3() throws Exception {
        AnswerVO result = database.queryAnswer("M", "选择一项", "选择一项", "选择一项", "选择一项");
        assertNull(result);
    }

    @Test
    public void shouldQueryAnswer4() throws Exception {
        AnswerVO result = database.queryAnswer("M", "爸爸", "爸爸", "爸爸", "选择一项");
        assertEquals("曾祖父", result.getAnswer());
        assertEquals("M", result.getGender());
        assertTrue(result.getOldInd());
    }
}