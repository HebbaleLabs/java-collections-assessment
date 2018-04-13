package com.echidna.assessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CollectionsAssessmentTest {
    
    @Test
    public void testSortAscendingEmptyAndNull() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        List<String> result = assessment.sortAscending(null);
        assertNotNull(result != null);
        assertTrue(result.size() == 0);
        
        result = assessment.sortAscending(new String[]{});
        assertNotNull(result != null);
        assertTrue(result.size() == 0);
    }
    
    @Test
    public void testSortAscendingAlphabets() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        List<String> result = assessment.sortAscending(new String[]{"Hamlet","Othello","Antonio","Portia","Bassanio","Shylock"});
        assertNotNull(result != null);
        assertTrue(result.size() == 6);
        List<String> expectedResult = Arrays.asList(new String[]{"Antonio","Bassanio","Hamlet","Othello","Portia","Shylock"});
        for(int ctr=0; ctr<6; ctr++) {
            if(!result.get(ctr).equals(expectedResult.get(ctr))) {
                fail("Found " + result.get(ctr) + " instead of " + expectedResult.get(ctr));
            }
        }
    }
    
    @Test
    public void testSortAscendingNumbers() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        List<String> result = assessment.sortAscending(new String[]{"1","4","2","3","7","8","6"});
        assertNotNull(result != null);
        assertTrue(result.size() == 7);
        List<String> expectedResult = Arrays.asList(new String[]{"1","2","3","4","6","7","8"});
        for(int ctr=0; ctr<7; ctr++) {
            if(!result.get(ctr).equals(expectedResult.get(ctr))) {
                fail("Found " + result.get(ctr) + " instead of " + expectedResult.get(ctr));
            }
        }
    }
    
    @Test
    public void testfindString() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        int index = assessment.findString(Arrays.asList(new String[]{"1","4","2","3","7","8","6"}),"2");
        assertEquals(2, index);
    }
    
    @Test
    public void testfindStringDuplicates() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        int index = assessment.findString(Arrays.asList(new String[]{"1","4","2","3","7","8","6","3"}),"3");
        assertEquals(3, index);
    }
    
    @Test
    public void testfindStringZeroMatch() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        int index = assessment.findString(Arrays.asList(new String[]{"1","4","2","3","7","8","6","3"}),"9");
        assertEquals(-1, index);
    }
    
    @Test
    public void testfindStringFirstElement() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        int index = assessment.findString(Arrays.asList(new String[]{"1","4","2","3","7","8","6","3"}),"1");
        assertEquals(0, index);
    }
    
    @Test
    public void testfindStringLastElement() {
        CollectionsAssessment assessment = new CollectionsAssessment();
        int index = assessment.findString(Arrays.asList(new String[]{"1","4","2","3","7","8","6"}),"6");
        assertEquals(6, index);
    }

    @Test
    public void testCheckUsageOfCollectionsSort() {
        boolean hasUsed = false;
        BufferedReader br = null;
        String strLine = "";
        String fileName = "src/main/java/com/echidna/assessment/CollectionsAssessment.java";
        try {
            br = new BufferedReader( new FileReader(fileName));
            while( (strLine = br.readLine()) != null){
                if(strLine.contains("Collections.sort")){
                    hasUsed = true;
                }
            }
            assertEquals("Collections.sort() has been used", false , hasUsed);
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Unable to read the file: " + fileName);
        }
    }
}
