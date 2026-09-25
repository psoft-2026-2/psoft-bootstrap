package model;

public enum AssinaturaCliente {
 
    STANDARD {
        @Override
        public double getDesconto() {
            return 0.0; 
        }
    },
    PREMIUM {
        @Override
        public double getDesconto() {
            return 0.05; 
        }
    };
 
    public abstract double getDesconto();
}

