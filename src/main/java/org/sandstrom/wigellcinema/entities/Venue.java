package org.sandstrom.wigellcinema.entities;



    public enum Venue {
        SALONG_1("Salong 1", 100, new String[]{"Projektor", "Ljudsystem"}),
        SALONG_2("Salong 2", 150, new String[]{"Projektor", "Luftkonditionering"}),
        SALONG_3("Salong 3", 200, new String[]{"Ljudsystem", "Luftkonditionering"}),
        SALONG_4("Salong 4", 80, new String[]{"Projektor", "Luftkonditionering"});

        private final String name;
        private final int maxNoOfGuests;
        private final String[] facilities;

        Venue(String name, int maxNoOfGuests, String[] facilities) {
            this.name = name;
            this.maxNoOfGuests = maxNoOfGuests;
            this.facilities = facilities;
        }

        public String getName() {
            return name;
        }

        public int getMaxNoOfGuests() {
            return maxNoOfGuests;
        }

        public String[] getFacilities() {
            return facilities;
        }

        @Override
        public String toString() {
            return "Venue{" +
                    "name='" + name + '\'' +
                    ", maxNoOfGuests=" + maxNoOfGuests +
                    ", facilities=" + String.join(", ", facilities) +
                    '}';
        }
    }


