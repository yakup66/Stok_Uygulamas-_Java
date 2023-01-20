package swingcrud;

import java.util.Collection;

public class Stok {
	String stok_kodu;
	String stok_adi;
    String stok_tipi ;
    String stok_birim ;
    String stok_barkod ;
    String stok_kdv ;
    String stok_aciklama;
    String stok_tarih;
    
    
    
	public Stok(String stok_kodu, String stok_adi, String stok_tipi, String stok_birim, String stok_barkod, String stok_kdv,
			String stok_aciklama, String stok_tarih) {
		super();
		this.stok_kodu = stok_kodu ;
		this.stok_adi = stok_adi;
		this.stok_tipi = stok_tipi;
		this.stok_birim = stok_birim;
		this.stok_barkod = stok_barkod;
		this.stok_kdv = stok_kdv;
		this.stok_aciklama = stok_aciklama;
		this.stok_tarih = stok_tarih;
	}
	
	
	public String getStok_kodu() {
		return stok_kodu;
	}


	public void setStok_kodu(String stok_kodu) {
		this.stok_kodu = stok_kodu;
	}


	public String getStok_adi() {
		return stok_adi;
	}
	public void setStok_adi(String stok_adi) {
		this.stok_adi = stok_adi;
	}
	public String getStok_tipi() {
		return stok_tipi;
	}
	public void setStok_tipi(String stok_tipi) {
		this.stok_tipi = stok_tipi;
	}
	public String getStok_birim() {
		return stok_birim;
	}
	public void setStok_birim(String stok_birim) {
		this.stok_birim = stok_birim;
	}
	public String getStok_barkod() {
		return stok_barkod;
	}
	public void setStok_barkod(String stok_barkod) {
		this.stok_barkod = stok_barkod;
	}
	public String getStok_kdv() {
		return stok_kdv;
	}
	public void setStok_kdv(String stok_kdv) {
		this.stok_kdv = stok_kdv;
	}
	public String getStok_aciklama() {
		return stok_aciklama;
	}
	public void setStok_aciklama(String stok_aciklama) {
		this.stok_aciklama = stok_aciklama;
	}
	public String getStok_tarih() {
		return stok_tarih;
	}
	public void setStok_tarih(String stok_tarih) {
		this.stok_tarih = stok_tarih;
	}


	public void addAll(Collection<? extends Stok> stok) {
		// TODO Auto-generated method stub
		
	}
    
    

}
