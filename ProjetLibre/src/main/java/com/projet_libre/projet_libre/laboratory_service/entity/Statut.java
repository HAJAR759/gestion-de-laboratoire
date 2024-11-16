package com.projet_libre.projet_libre.laboratory_service.entity;

public enum Statut {
    ACTIF,
    INACTIF;
 // Méthode pour obtenir l'énumération à partir d'une valeur entière
    public static Statut fromInt(int i) {
        switch (i) {
            case 1:
                return INACTIF;
            case 0:
            	return ACTIF;
            default:
                return ACTIF;
        }
    }
}