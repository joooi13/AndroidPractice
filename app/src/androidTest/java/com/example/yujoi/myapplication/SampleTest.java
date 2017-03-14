package com.example.yujoi.myapplication;

import android.content.SharedPreferences;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by yujoi on 2017/03/13.
 */

public class SampleTest {

    @Test
    public void testMockArray() throws Exception {
        ArrayList mockList = mock(ArrayList.class);
        // get(0)で神奈川県を返すようにモック化する
        when(mockList.get(0)).thenReturn("神奈川県");
        assertEquals("神奈川県", mockList.get(0));
    }

    @Test
    public void testPref() throws Exception {
        SharedPreferences sp = Mockito.mock(SharedPreferences.class);
        Mockito.doReturn("ポテト").when(sp).getString("food", "");
        assertEquals("ポテト", sp.getString("food", ""));
    }
}
