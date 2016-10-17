package chapter.two.hello_world;
public class WorldGen {
	String planetName = "Earth";
	int planetMass;
	double planetGravity;
	int planetColonies;
	long planetPopulation;
	int planetBases;
	int planetMilitary;
	boolean planetProtection;
	public WorldGen (String name, int mass, double gravity) {
		planetName = name;
		planetMass = mass;
		planetGravity = gravity;
		planetColonies = 0;
		planetPopulation = 0;
		planetBases = 0;
		planetMilitary = 0;
		planetProtection = false;
	}
	void setPlanetColonies (int numColonies) {
		planetColonies += numColonies;
	}
	int getPlanetColonies() {
		return planetColonies;
	}
	void setPlanetMilitary (int numBases) {
		planetBases += numBases;
	}
	int getPlanetMilitary() {
		return planetBases;
	}
	void turnForceFieldOn() {
		planetProtection = true;
	}
	void turnForceFieldOff() {
		planetProtection = false;
	}
	boolean getForceFieldState() {
		return planetProtection;
	}
	void setColonyImmigration (int numColonists) {
		planetPopulation += numColonists;
	}
	long getColonyImmigration() {
		return planetPopulation;
	}
	void setBaseProtection (int numForces) {
		planetMilitary += numForces;
	}
	int getBaseProtection() {
		return planetMilitary;
	}
}
