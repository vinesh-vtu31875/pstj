class UndergroundSystem {
    HashMap<Integer, String> station = new HashMap<>();
    HashMap<Integer, Integer> time = new HashMap<>();
    HashMap<String, double[]> trips = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        station.put(id, stationName);
        time.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String start = station.get(id);
        int startTime = time.get(id);

        String key = start + "#" + stationName;

        if (!trips.containsKey(key)) {
            trips.put(key, new double[]{0, 0});
        }

        trips.get(key)[0] += t - startTime;
        trips.get(key)[1]++;

        station.remove(id);
        time.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        double[] data = trips.get(key);
        return data[0] / data[1];
    }
}