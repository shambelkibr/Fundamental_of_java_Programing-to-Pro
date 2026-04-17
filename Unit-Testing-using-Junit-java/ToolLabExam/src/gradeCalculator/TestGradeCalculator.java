//package gradeCalculator;
//
//package testGradeCalculator;
//
//import gradeCalculator.GradeCalculator;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TestGradeCalculator {
//
//    GradeCalculator gc = new GradeCalculator();
//
//    // Grade A Test
//    @ParameterizedTest
//    @ValueSource(ints = {90, 95, 100})
//    @DisplayName("Scores 90–100 should return Grade A")
//    void testGradeA(int score) {
//        assertEquals('A', gc.calculateGrade(score));
//    }
//
//    // Grade B Test
//    @ParameterizedTest
//    @ValueSource(ints = {80, 85, 89})
//    @DisplayName("Scores 80–89 should return Grade B")
//    void testGradeB(int score) {
//        assertEquals('B', gc.calculateGrade(score));
//    }
//
//    // Grade C Test
//    @ParameterizedTest
//    @ValueSource(ints = {70, 75, 79})
//    @DisplayName("Scores 70–79 should return Grade C")
//    void testGradeC(int score) {
//        assertEquals('C', gc.calculateGrade(score));
//    }
//
//    // Grade D Test
//    @ParameterizedTest
//    @ValueSource(ints = {60, 65, 69})
//    @DisplayName("Scores 60–69 should return Grade D")
//    void testGradeD(int score) {
//        assertEquals('D', gc.calculateGrade(score));
//    }
//
//    // Grade F Test
//    @ParameterizedTest
//    @ValueSource(ints = {0, 40, 59})
//    @DisplayName("Scores below 60 should return Grade F")
//    void testGradeF(int score) {
//        assertEquals('F', gc.calculateGrade(score));
//    }
//}
