class IntegerCompare {
    public static void main(String[] args) {
        Integer i1 = 1000;
        Integer i2 = 1000;
        if (i1 != i2) {
            System.out.println("Different objects");
        } else {
            System.out.println("Same objects");
        }
        int i3 = 1000;
        int i4 = 1000;
        if (i3 != i4) {
            System.out.println("Different objects");
        } else {
            System.out.println("Same objects");
        }
        Integer i5 = 10;
        Integer i6 = 10; // Cache
        if (i5 != i6) {
            System.out.println("Different objects");
        } else {
            System.out.println("Same objects");
        }
    }
}