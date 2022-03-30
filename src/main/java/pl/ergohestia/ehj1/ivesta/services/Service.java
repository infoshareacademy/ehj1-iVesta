package pl.ergohestia.ehj1.ivesta.services;

public interface Service<T> {
    public void printElements();
    public void addElement(T element);

    public static boolean isNumeric(String inputString){
        if (inputString == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(inputString);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
