package com.ismaelmohamedbouh;

import java.util.Arrays;

class Solution {
    private static final long INF = Long.MAX_VALUE;
    private static final int MOD = (int) 1e9 + 7;

    public int minWastedSpace(int[] paquets, int[][] boites) {
        Arrays.sort(paquets);
        long espacePerduMin = INF;

        for (int[] boite : boites) {
            Arrays.sort(boite);
            if (peutAccommoderTousLesPaquets(paquets, boite)) {
                long espacePerduActuel = calculerEspacePerdu(paquets, boite);
                espacePerduMin = Math.min(espacePerduMin, espacePerduActuel);
            }
        }

        if (espacePerduMin == INF) {
            return -1;
        }

        long tailleTotalePaquets = calculerTailleTotalePaquets(paquets);
        return (int) ((espacePerduMin - tailleTotalePaquets) % MOD);
    }

    private boolean peutAccommoderTousLesPaquets(int[] paquets, int[] boite) {
        return paquets[paquets.length - 1] <= boite[boite.length - 1];
    }

    private long calculerEspacePerdu(int[] paquets, int[] boite) {
        long espacePerduActuel = 0;
        int indexDebut = 0;
        for (int taille : boite) {
            int indexFin = borneSuperieure(paquets, taille, indexDebut);
            espacePerduActuel += (long) (indexFin - indexDebut) * taille;
            indexDebut = indexFin;
        }
        return espacePerduActuel;
    }

    private long calculerTailleTotalePaquets(int[] paquets) {
        long tailleTotalePaquets = 0;
        for (int paquet : paquets) {
            tailleTotalePaquets += paquet;
        }
        return tailleTotalePaquets;
    }

    private int borneSuperieure(int[] nums, int cible, int gauche) {
        int droite = nums.length;
        while (gauche < droite) {
            int milieu = gauche + (droite - gauche) / 2;
            if (nums[milieu] > cible) {
                droite = milieu;
            } else {
                gauche = milieu + 1;
            }
        }
        return gauche;
    }
}