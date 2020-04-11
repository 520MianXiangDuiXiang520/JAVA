package Note.enumDemo;

interface Poem {
    void poem();
}


public enum Season implements Poem{
    SPRING("春天") {
        @Override
        public void poem() {
            System.out.println("春眠不觉晓");
        }
    },
    SUMMER("夏天") {
        @Override
        public void poem() {
            System.out.println("连雨不知春去，一晴方觉夏深");
        }
    },
    AUTUMN("秋天") {
        @Override
        public void poem() {
            System.out.println("自古逢秋悲寂寥");
        }
    },
    WINTER("冬天") {
        @Override
        public void poem() {
            System.out.println("忽如一夜春风来");
        }
    };

    private String hans;
    Season(String hans) {
        this.hans = hans;
    }

    @Override
    public String toString() {
        return "Season{" +
                "hans='" + hans + '\'' +
                '}';
    }
}
