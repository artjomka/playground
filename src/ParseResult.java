/**
 * Parse result
 */
public class ParseResult {
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;

    public ParseResult(String value1, String value2, String value3, String value4, String value5) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParseResult that = (ParseResult) o;

        if (value1 != null ? !value1.equals(that.value1) : that.value1 != null) return false;
        if (value2 != null ? !value2.equals(that.value2) : that.value2 != null) return false;
        if (value3 != null ? !value3.equals(that.value3) : that.value3 != null) return false;
        return true;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }

    public String getValue4() {
        return value4 + " " + value5;
    }

    public String getValue5() {
        return value5;
    }
}
