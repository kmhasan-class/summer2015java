/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

/**
 *
 * @author kmhasan
 */
public enum Grade {
    A_PLUS("A+", 4.00, 80, 101),
    A("A", 3.75, 75, 80),
    A_MINUS("A-", 3.50, 70, 75),
    B_PLUS("B+", 3.25, 65, 70),
    B("B", 3.00, 60, 65),
    B_MINUS("B-", 2.75, 55, 60),
    C_PLUS("C+", 2.50, 50, 55),
    C("C", 2.25, 45, 50),
    D("D", 2.00, 40, 45),
    F("F", 0.00, 0, 40),
    R("Reported", 0.00, 0, 0),
    S("Satisfactory", 0.00, 40, 101),
    U("Unsatisfactory", 0.00, 0, 40),
    I("Incomplete", 0.00, 0, 101);
    
    private String letterGrade;
    private double numericGrade;
    private double minScore;
    private double maxScore;

    private Grade(String letterGrade, double numericGrade, double minScore, double maxScore) {
        this.letterGrade = letterGrade;
        this.numericGrade = numericGrade;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getNumericGrade() {
        return numericGrade;
    }

    public double getMinScore() {
        return minScore;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public static Grade getGrade(double score) {
        for (Grade g: Grade.values())
            if (score >= g.minScore && score < g.maxScore)
                return g;
        return Grade.I;
    }
}
