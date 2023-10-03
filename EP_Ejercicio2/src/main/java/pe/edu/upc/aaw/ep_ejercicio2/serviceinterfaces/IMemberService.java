package pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces;

import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;

import java.util.List;

public interface IMemberService {
    public void insert(Member jmtrMember);
    public List<String[]> QuantityMembersPerStatusPerMonth(String jmtrQMonth);
}
