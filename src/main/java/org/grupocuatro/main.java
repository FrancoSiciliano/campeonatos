package org.grupocuatro;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.EntityManager;

public class main {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
    }
}
