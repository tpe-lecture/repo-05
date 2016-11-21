package tpe.enumeration.own;

public enum WuerfelTyp {
        D4(4), D6(6), D8(8), D10(10), D12(12);

        private int augen;

        private WuerfelTyp(int augen) {
            this.augen = augen;
        }

        public int getAugen(){
            return augen;
        }

        public double average(WuerfelTyp D){
           return (D.augen/2+0.5);
        }

}
