package pe.edu.upc.aaw.ep_ejercicio2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;
import pe.edu.upc.aaw.ep_ejercicio2.repositories.IMemberRepository;
import pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces.IMemberService;

import java.util.List;

@Service
public class MemberServiceImplement implements IMemberService {
    @Autowired
    private IMemberRepository jmtrMr;

    @Override
    public void insert(Member jmtrMember) {
        jmtrMr.save(jmtrMember);
    }

    @Override
    public List<String[]> QuantityMembersPerStatusPerMonth(String jmtrQMonth) {
        return jmtrMr.QuantityMembersPerStatusPerMonth(jmtrQMonth);
    }
}
