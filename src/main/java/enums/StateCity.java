package enums;

public enum StateCity {
    NCR("NCR", new String[]{"Delhi","Gurgaon","Noida"}),
    Uttar_Pradesh("Uttar Pradesh", new String[]{"Agra","Lucknow","Merrut"}),
    Haryana("Haryana", new String[]{"Karnal","Panipat"}),
    Rajasthan("Rajasthan", new String[]{"Jaipur","Jaiselmer"});

    private String state;
    private String[] cities;

    StateCity(String state, String[] cities) {
        this.state = state;
        this.cities = cities;
    }

    public String getState() {
        return state;
    }

    public String[] getCities() {
        return cities;
    }
}
