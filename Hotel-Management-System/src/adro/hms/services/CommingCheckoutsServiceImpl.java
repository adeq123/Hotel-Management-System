package adro.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.GuestDAO;
import adro.hms.entity.Guest;

@Service
public class CommingCheckoutsServiceImpl implements CommingCheckoutsService {
	
	@Autowired
	GuestDAO guestDAO;
	
	@Override
	@Transactional
	public List<Guest> getCommingCheckouts() {
		
		return guestDAO.getCommingCheckouts();
	}

}
