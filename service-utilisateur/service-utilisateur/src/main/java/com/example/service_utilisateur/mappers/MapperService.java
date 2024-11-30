package com.example.service_utilisateur.mappers;

import com.example.service_utilisateur.dtos.InscriptionUtilisateur;
import com.example.service_utilisateur.dtos.UtilisateurDto;
import com.example.service_utilisateur.entities.Login;
import com.example.service_utilisateur.entities.Utilisateur;
import com.example.service_utilisateur.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperService {
  //  @Autowired
  //  private PasswordEncoder passwordEncoder;
    @Autowired
    LoginRepository loginRepository;

    public UtilisateurDto UtilisateurDtoToUtilisateur(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();

        // Mappage des champs un à un
        utilisateurDto.setNomComplet(utilisateur.getNomComplet());
        utilisateurDto.setEmail(utilisateur.getLogin().getEmail());
        utilisateurDto.setNumTel(utilisateur.getNumTel());
        utilisateurDto.setProfession(utilisateur.getLogin().getRole());

        return utilisateurDto;
    }
    public Login convertInscriptionUtilisateurToLogin(InscriptionUtilisateur inscription){
        Login login=new Login();
        login.setEmail(inscription.getEmail());
      //  login.setMdp(passwordEncoder.encode(inscription.getMdp()));
        login.setMdp(inscription.getMdp());
        login.setRole(inscription.getRole());
        return  login;
    }
    public Utilisateur convertInscriptinToUtilisateur(InscriptionUtilisateur inscription){
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setNomComplet(inscription.getNomComplet());
        utilisateur.setNumTel(inscription.getNumTel());
        utilisateur.setCin(inscription.getCin());
        utilisateur.setLogin(loginRepository.findLoginByEmail(inscription.getEmail()));
        utilisateur.setSignature(inscription.getSignature());

        return utilisateur;
    }


}
