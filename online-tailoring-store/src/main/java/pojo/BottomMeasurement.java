package pojo;



	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="BottomMeasurement")

		

	public class BottomMeasurement {
	@Id @GeneratedValue
		private int bottomId;
		private String fabric;
		private String materialType;
		private int duration;
		private double amount, bottomLength,hip,kneeLength;

			
		public int getBottomId(){
			return bottomId;
		}
		public void setBottomId(int bottomId){
			this.bottomId = bottomId;
		}
		public String getFabric(){
			return fabric;
		}
		public void setFabric(String fabric){
			this.fabric = fabric;
		}
		public String getmaterialType(){
			return materialType;
		}
		public void setMaterialType(String materialType){
			this.materialType = materialType;
		}
		public int Duration(){
			return duration;
		}
		public void setDuration(int duration){
			this.duration = duration;
		}
		public double Amount(){
			return amount;
		}
		public void setAmount(double amount){
			this.amount = amount;
		}
		public double getBottomLength(){
			return bottomLength;
		}
		public void setBottomLength(double bottomLength){
			this.bottomLength = bottomLength;
		}
		public double getHip(){
			return hip;
		}
		public void setHip(double hip){
			this.hip = hip;
		}
		public double getKneeLength(){
			return kneeLength;
		}
		public void setKneeLength(double kneeLength){
			this.kneeLength = kneeLength;
		}

}
