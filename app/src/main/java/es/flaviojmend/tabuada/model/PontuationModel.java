package es.flaviojmend.tabuada.model;

public class PontuationModel {

    public static final String sumsRight = "es.flaviojmend.tabuada.sumsRight";
    public static final String sumsWrong = "es.flaviojmend.tabuada.sumsWrong";
    public static final String subtractionsRight = "es.flaviojmend.tabuada.subtractionsRight";
    public static final String subtractionsWrong = "es.flaviojmend.tabuada.subtractionsWrong";
    public static final String multiplicationsRight = "es.flaviojmend.tabuada.multiplicationsRight";
    public static final String multiplicationsWrong = "es.flaviojmend.tabuada.multiplicationsWrong";
    public static final String divisionsRight = "es.flaviojmend.tabuada.divisionsRight";
    public static final String divisionsWrong = "es.flaviojmend.tabuada.divisionsWrong";

    private Integer totalSumsRight = 0;
    private Integer totalSumsWrong = 0;
    private Integer totalSubtractionsRight = 0;
    private Integer totalSubtractionsWrong = 0;
    private Integer totalMultiplicationsRight = 0;
    private Integer totalMultiplicationsWrong = 0;
    private Integer totalDivisionsRight = 0;
    private Integer totalDivisionsWrong = 0;


    public Integer getTotalSumsRight() {
        return totalSumsRight;
    }

    public PontuationModel setTotalSumsRight(Integer totalSumsRight) {
        this.totalSumsRight = totalSumsRight;
        return this;
    }

    public Integer getTotalSumsWrong() {
        return totalSumsWrong;
    }

    public PontuationModel setTotalSumsWrong(Integer totalSumsWrong) {
        this.totalSumsWrong = totalSumsWrong;
        return this;
    }

    public Integer getTotalSubtractionsRight() {
        return totalSubtractionsRight;
    }

    public PontuationModel setTotalSubtractionsRight(Integer totalSubtractionsRight) {
        this.totalSubtractionsRight = totalSubtractionsRight;
        return this;
    }

    public Integer getTotalSubtractionsWrong() {
        return totalSubtractionsWrong;
    }

    public PontuationModel setTotalSubtractionsWrong(Integer totalSubtractionsWrong) {
        this.totalSubtractionsWrong = totalSubtractionsWrong;
        return this;
    }

    public Integer getTotalMultiplicationsRight() {
        return totalMultiplicationsRight;
    }

    public PontuationModel setTotalMultiplicationsRight(Integer totalMultiplicationsRight) {
        this.totalMultiplicationsRight = totalMultiplicationsRight;
        return this;
    }

    public Integer getTotalMultiplicationsWrong() {
        return totalMultiplicationsWrong;
    }

    public PontuationModel setTotalMultiplicationsWrong(Integer totalMultiplicationsWrong) {
        this.totalMultiplicationsWrong = totalMultiplicationsWrong;
        return this;
    }

    public Integer getTotalDivisionsRight() {
        return totalDivisionsRight;
    }

    public PontuationModel setTotalDivisionsRight(Integer totalDivisionsRight) {
        this.totalDivisionsRight = totalDivisionsRight;
        return this;
    }

    public Integer getTotalDivisionsWrong() {
        return totalDivisionsWrong;
    }

    public PontuationModel setTotalDivisionsWrong(Integer totalDivisionsWrong) {
        this.totalDivisionsWrong = totalDivisionsWrong;
        return this;
    }
}
