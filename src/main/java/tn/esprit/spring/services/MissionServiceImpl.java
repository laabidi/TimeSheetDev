package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
@Service
public class MissionServiceImpl implements IMissionService  {
	@Autowired
	MissionRepository cr;
	private static final Logger L =  LogManager.getLogger(MissionServiceImpl.class);
	@Override
	public Mission addMission(Mission mission) {
		// TODO Auto-generated method stub
		return cr.save(mission);
	}
	@Override
	public List<Mission> retrieveAllMissions() {
		// TODO Auto-generated method stub
		List<Mission> missions = (List<Mission>) cr.findAll();
		for (Mission mission : missions){
		L.info("comment +++: " + mission );}
		return missions;
	}
	@Override
	public void deleteMission(int id) {
		// TODO Auto-generated method stub
	  
	       cr.deleteById(id);}
	
	}
	
	
	
	
	
	
	
	
		

