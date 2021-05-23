package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CheckService {

	@Override
	public boolean Check(JobSeeker jobSeeker) {
		
		KPSPublicSoapProxy client= new KPSPublicSoapProxy();
		
		var result = true;
		try {
			result= client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()), jobSeeker.getFirstName().toUpperCase(new Locale("tr")), 
					jobSeeker.getLastName().toUpperCase(new Locale("tr")), jobSeeker.getBirthYear());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
