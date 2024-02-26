package com.mycompany.objectdbproject;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author b15-20m
 */
public class ObjectDBProject {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    
    public static void main(String[] args) {
        crearConexion();
        //insertarDatos();
        //consultaDatosUsuario(1);
        //ConsultaDatosUsuarioConPedidos(1);
        //modificarDatos(1,"PEPE");
        //borrarDatos(1);
        //consultaDatosUsuarioJPQL(20);
        //consultaUsuariosJPQL();
        //borrarDatosJPQL(1);
        //consultaVariosCampos();
        //consultaDatosUsuarioNAMED(2);
        //consultaUsuariosCriteriaQuery();
        consultaVariosCamposCriteriaQuery();
        em.close();
        emf.close();
    }
    
    public static void crearConexion(){
        //Conexión a docker
        //emf = Persistence.createEntityManagerFactory("objectdb://localhost/proyecto.odb;user=admin;password=admin");
        
        //Conexion a local
        emf = Persistence.createEntityManagerFactory("./db/proyecto.odb");
        em = emf.createEntityManager();
    }
    
    //Operaciones sin JPQL
    public static void insertarDatos(){
        em.getTransaction().begin();
        
        Usuarios usu1 = new Usuarios(1,"ANA", "ana2014");
        em.persist(usu1);
        
        Usuarios usu2 = new Usuarios(2,"LUIS", "luis2014");
        em.persist(usu2);
        
        Usuarios usu3 = new Usuarios(3,"SILVIA", "silvia2014");
        em.persist(usu3);
        
        Usuarios usu4 = new Usuarios(4,"PEDRO", "pedro2014");
        em.persist(usu4);
        
        Productos prod1 = new Productos(1, "TABLET", 150);
        em.persist(prod1);
        
        Productos prod2 = new Productos(2, "RELOJ", 60);
        em.persist(prod2);
        
        Productos prod3 = new Productos(3, "GAMEPAD", 40);
        em.persist(prod3);
        
        Productos prod4 = new Productos(4, "CAJA CPU", 80);
        em.persist(prod4);
        
        Productos prod5 = new Productos(5, "PORTATIL", 1500);
        em.persist(prod5);
        
        Productos prod6 = new Productos(6, "RATÓN", 25);
        em.persist(prod6);
        
        Pedidos ped1 = new Pedidos(1, 30, Metodos.convertirDate("01/01/2024"),prod1, usu1);
        em.persist(ped1);
        
        Pedidos ped2 = new Pedidos(2, 40, Metodos.convertirDate("02/02/2024"),prod2, usu2);
        em.persist(ped2);
        
        Pedidos ped3 = new Pedidos(3, 50, Metodos.convertirDate("03/03/2024"),prod3, usu3);
        em.persist(ped3);
        
        Pedidos ped4 = new Pedidos(4, 60, Metodos.convertirDate("04/04/2024"),prod4, usu4);
        em.persist(ped4);
        
        em.getTransaction().commit();
    }
    
    public static void borrarDatos(int idUsuario){
        em.getTransaction().begin();
        Usuarios usuario = em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        em.remove(usuario);
        em.getTransaction().commit();
    }    
    
    public static void modificarDatos(int idUsuario, String nombre){
        consultaDatosUsuario(idUsuario);
        Usuarios usuario = em.find(Usuarios.class, idUsuario); //Como no hacemos el lockmode, no hace falta la transaccion
        em.getTransaction().begin();
        usuario.setNombre(nombre);
        em.getTransaction().commit();
        consultaDatosUsuario(idUsuario);
        
    }
    
    //Consultas sin JPQL
    private static void consultaDatosUsuario(int idUsuario){
        em.getTransaction().begin();
        Usuarios usuario = em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        if (usuario != null){
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Contraseña: " + usuario.getContra());
        }else{
            System.out.println("No existe usuario con ese id");
        }
        em.getTransaction().commit();
    }
    
    private static void ConsultaDatosUsuarioConPedidos(int idUsuario){
        em.getTransaction().begin();
        Usuarios usuario = em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        if (usuario != null){
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Contraseña: " + usuario.getContra());
            
            Pedidos p;
            Collection<Pedidos> coleccion = usuario.getPedidosCollection();
            Iterator<Pedidos> it =coleccion.iterator();
            while (it.hasNext()){
                p = it.next();
                System.out.println("Pedido: " + p.getIdpedido());
                System.out.println("FECHA: " +  p.getFechaEntrega());
                System.out.println("PRECIO TOTAL" + p.getPrecioTotal());
            }
        }else{
            System.out.println("No existe usuario con ese id");
        }
        em.getTransaction().commit();
    }
    
    
    //Consultas con JPQL
    
    private static void consultaDatosUsuarioJPQL(int idUsuario){
        Usuarios usuario = null;
        TypedQuery<Usuarios> query = em.createQuery(
                "select u from Usuarios u where u.idusuario =:IDUSUARIOP" , 
                Usuarios.class);
        query.setParameter("IDUSUARIOP", idUsuario);
        try{
            usuario = query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No existe un usuario con ese id");
        }
        if (usuario != null){
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Contraseña: " + usuario.getContra());
        }
    }
    
    private static void consultaUsuariosJPQL(){
        Usuarios usuario ;
        TypedQuery<Usuarios> query = em.createQuery("select  from Usuarios", Usuarios.class);
        try{
            Collection<Usuarios> coleccion = query.getResultList();
            Iterator<Usuarios> it = coleccion.iterator();
            while (it.hasNext()){
                usuario = it.next();
                System.out.println("Usuario: " + usuario.getNombre());
                System.out.println("Contraseña: " + usuario.getContra());
            }
        }catch(NoResultException e){
            System.out.println("No existen usuarios");
        }
    }
    
    private static void consultaVariosCampos(){
        TypedQuery<Object[]> query  = em.createQuery("select idusuario, nombre from Usuarios", Object[].class);
        
        List<Object[]> list = query.getResultList();
        System.out.print("ID USUARIO \t");
        System.out.print("NOMBRE\n");
        
        for (Object[] e:list){
            System.out.print(e[0] + "\t");
            System.out.println("\t" + e[1]);
        }
    }
    
    //Named Queries
    private static void consultaDatosUsuarioNAMED(int idusuario){
        Usuarios usuario = null;
        TypedQuery<Usuarios> query = em.createNamedQuery(
                "Usuarios.findById" , 
                Usuarios.class);
        query.setParameter("IDUSUARIOP", idusuario);
        try{
            usuario = query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No existe un usuario con ese id");
        }
        if (usuario != null){
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Contraseña: " + usuario.getContra());
        }
    }
    
    //Criteria Query
    
    private static void consultaUsuariosCriteriaQuery(){ // = select from Usuarios
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuarios> query = cb.createQuery(Usuarios.class);
        Root<Usuarios> u = query.from(Usuarios.class);
        query.select(u);
        List<Usuarios> list = em.createQuery(query).getResultList();
        
        for (Usuarios e:list){
            System.out.println("Nombre: " + e.getNombre());
        }
    }
    
    private static void consultaVariosCamposCriteriaQuery(){  // = select nombre, contra from usuarios
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Usuarios> u = query.from(Usuarios.class);
        query.select(cb.array(u.get("nombre"),u.get("contra")));
        List<Object[]> list = em.createQuery(query).getResultList();
        
        System.out.print("ID USUARIO \t");
        System.out.print("NOMBRE\n");
        
        for (Object[] e:list){
            System.out.print(e[0] + "\t");
            System.out.println("\t" + e[1]);
        }
    }
    
    //Operacion con JPQL
    
    private static void borrarDatosJPQL(int idUsuario){
        Query query = em.createQuery("delete from Usuarios where idusuario=:IDUSUARIOP");
        query.setParameter("IDUSUARIOP", idUsuario);
        em.getTransaction().begin();
        int deletedCount = query.executeUpdate();
        em.getTransaction().commit();
        consultaUsuariosJPQL();
    }
    
    private static void modificarDatosJPQL(int idUsuario, String nombre){
        String ql = "update Usuarios set nombre=" + nombre +"where idusuario=:IDUSUARIOP";
        Query query = em.createQuery(ql);
        query.setParameter("IDUSUARIOP", idUsuario);
        int updatedCount = query.executeUpdate();
        em.getTransaction().commit();
        consultaUsuariosJPQL();
    }
    
}
