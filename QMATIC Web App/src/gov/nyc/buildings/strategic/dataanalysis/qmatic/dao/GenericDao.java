package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

public interface GenericDao <T, K> {
	
	T read(K k);

}
