import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class InsurancePolicy implements Comparable<InsurancePolicy>{
    private String policyNumber,policyholderName,coverageType;
    private LocalDate expiryDate;
    private double premiumAmount;
    public InsurancePolicy(String policyNumber,String policyholderName,LocalDate expiryDate,String coverageType,double premiumAmount){
        this.policyNumber=policyNumber;
        this.policyholderName=policyholderName;
        this.expiryDate=expiryDate;
        this.coverageType=coverageType;
        this.premiumAmount=premiumAmount;
    }
    public String getPolicyNumber(){return policyNumber;}
    public LocalDate getExpiryDate(){return expiryDate;}
    public String getCoverageType(){return coverageType;}
    @Override
    public int compareTo(InsurancePolicy other){return this.expiryDate.compareTo(other.expiryDate);}
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy policy=(InsurancePolicy) obj;
        return Objects.equals(policyNumber,policy.policyNumber);
    }
    @Override
    public int hashCode(){return Objects.hash(policyNumber);}
    @Override
    public String toString(){
        return "Policy No - "+policyNumber+", Holder - "+policyholderName+", Expiry - "+expiryDate+", Type - "+coverageType+", Premium - $"+premiumAmount;
    }
}
class PolicyManager{
    private Set<InsurancePolicy> hashSet=new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet=new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet=new TreeSet<>();
    public void addPolicy(InsurancePolicy policy){
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    public void displayAllPolicies(Set<InsurancePolicy> policies){
        for(InsurancePolicy policy:policies){
            System.out.println(policy);
        }
    }
    public Set<InsurancePolicy> getExpiringSoon(){
        LocalDate today=LocalDate.now();
        Set<InsurancePolicy> expiringSoon=new HashSet<>();
        for(InsurancePolicy policy:treeSet){
            if(ChronoUnit.DAYS.between(today,policy.getExpiryDate())<=30){
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType){
        Set<InsurancePolicy> result=new HashSet<>();
        for(InsurancePolicy policy:hashSet){
            if(policy.getCoverageType().equalsIgnoreCase(coverageType)){
                result.add(policy);
            }
        }
        return result;
    }
    public Set<InsurancePolicy> getDuplicatePolicies(){
        Set<String> seenPolicyNumbers=new HashSet<>();
        Set<InsurancePolicy> duplicates=new HashSet<>();
        for(InsurancePolicy policy:hashSet){
            if(!seenPolicyNumbers.add(policy.getPolicyNumber())){
                duplicates.add(policy);
            }
        }
        return duplicates;
    }
    public void comparePerformance(){
        List<InsurancePolicy> samplePolicies=new ArrayList<>();
        for(int i=0;i<100000;i++){
            samplePolicies.add(new InsurancePolicy("P"+i,"Holder"+i,LocalDate.now().plusDays(i%365),"Type"+(i%3),i*10.5));
        }
        long start=System.nanoTime();
        for(InsurancePolicy policy:samplePolicies)hashSet.add(policy);
        long hashSetTime=System.nanoTime()-start;
        start=System.nanoTime();
        for(InsurancePolicy policy:samplePolicies)linkedHashSet.add(policy);
        long linkedHashSetTime=System.nanoTime()-start;
        start=System.nanoTime();
        for(InsurancePolicy policy:samplePolicies)treeSet.add(policy);
        long treeSetTime=System.nanoTime()-start;
        System.out.println("Performance Comparison Adding 100,000 Policies --> ");
        System.out.println("HashSet --> "+hashSetTime/1e6+" ms");
        System.out.println("LinkedHashSet --> "+linkedHashSetTime/1e6+" ms");
        System.out.println("TreeSet --> "+treeSetTime/1e6+" ms");
    }
    public Set<InsurancePolicy> getHashSetPolicies(){return hashSet;}
    public Set<InsurancePolicy> getLinkedHashSetPolicies(){return linkedHashSet;}
    public Set<InsurancePolicy> getTreeSetPolicies(){return treeSet;}
}
public class InsurancePolicyManagement{
    public static void main(String[] args){
        PolicyManager manager=new PolicyManager();
        InsurancePolicy p1=new InsurancePolicy("P-1","Riya",LocalDate.now().plusDays(10),"Health",5000);
        InsurancePolicy p2=new InsurancePolicy("P-2","Jiya",LocalDate.now().plusDays(40),"Auto",3000);
        InsurancePolicy p3=new InsurancePolicy("P-3","Siya",LocalDate.now().plusDays(20),"Home",7000);
        InsurancePolicy p4=new InsurancePolicy("P-4","Liya",LocalDate.now().plusDays(5),"Health",6000);
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);
        System.out.println("All Unique Policies HashSet -->");
        manager.displayAllPolicies(manager.getHashSetPolicies());
        System.out.println("Policies Expiring Soon --> ");
        manager.displayAllPolicies(manager.getExpiringSoon());
        System.out.println("Policies with Coverage Type 'Health' --> ");
        manager.displayAllPolicies(manager.getPoliciesByCoverageType("Health"));
        System.out.println("Performance Comparison --> ");
        manager.comparePerformance();
    }
}
