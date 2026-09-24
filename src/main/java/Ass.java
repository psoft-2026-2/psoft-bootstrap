public enum Ass {

    STANDARD {
        @Override
        public double getPercentualDesconto() {
            return 0.0;
        }
    },
    PREMIUM {
        @Override
        public double getPercentualDesconto() {
            return 0.05;
        }
    };

    public abstract double getPercentualDesconto();
}
