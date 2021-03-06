package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;


@ManagedBean(name = "listenerCategoria")
@SessionScoped
public class CategoriaBean{
    //@Inject
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
    
    private String nombreCategoria;
    private String descripcionCategoria;
    private List<Categoria> categorias;
    private List<String> nombres;
    private String nombreActualizar;
    private String descripcionActualizar;
    private String estadoActualizar;
    private DonutChartModel donutModel;
    private HashMap<String,Number> valoresGrafico;
    
    /**
     * Este PostConstruct se crea para poder agregar valores a la lsta de nombres de categorias
     * Tambien sirve para llamar de nuevo a esos valores y meterlos en la lista en caso
     * de haber insertado o actualizado alguno
     */
    @PostConstruct
    public void init(){
        nombres = new ArrayList<>();
        try {
            this.categorias = serviciosEscuela.consultarCategorias();
            for(Categoria categoria : categorias){
                this.nombres.add(categoria.getNombre());
            }
            createDonutModel();
        } catch (ExcepcionServiciosEscuela ex){
        }
    }
    
    /**
     * Con este metodo se le da valor a los valores que se quieran actualizar de la categoria
     * como ya se busc?? la categoria y se encontr??, se deja como valores predeterminados
     * de descripcion, nombre y estado a actualizar como los actuales 
     */
    public void getDatosActualizar(){
        for(Categoria categoria : categorias){
            if(categoria.getNombre().equals(nombreCategoria)){
                this.descripcionActualizar = categoria.getDescripcion();
                this.nombreActualizar = categoria.getNombre();
                this.estadoActualizar = categoria.getEstado();
            }
        }
    }
    
    public void createDonutModel() {
        donutModel = new DonutChartModel();
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<Number>();
        List<String> labels = new ArrayList<String>();
        List<String> bgColors = new ArrayList<String>();
        HashMap<String,Number> mapa = getValues();
        for(String key:getValues().keySet()){
            labels.add(key);
            bgColors.add(getColors());
        }
        for(Number value:getValues().values()){
           values.add(value);
        }
        dataSet.setData(values);
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        data.setLabels(labels);
        donutModel.setData(data);
    }
    
    public String getColors(){
        int r = (int)Math.random()*255;
        int b = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        String colores = "rgb("+r+", "+b+", "+g+")";
        return colores;
    }
    
    public HashMap<String,Number> getValues(){
        List<Categoria> categorias = new ArrayList<>();
        HashMap<String,Number> mapa = new HashMap<>();
        try{
            categorias = serviciosEscuela.consultarCategoriasMasBuscadas();
            for(Categoria categoria:categorias){
                mapa.put(categoria.getNombre(), categoria.getTotal());
            }
        }catch(ExcepcionServiciosEscuela e){
            e.printStackTrace();
        }
        return mapa;
    }
        
        
    /**
     * Metodo que retorna la tabla modificada con las categorias mas usadas en las necesidades 
     * @return -> List<Categoria> sentencia de las categorias mas usadas en las necesidades y ofertas
     */
    public List<Categoria> tablaCategoriasMasUsadas(){
        List<Categoria> categorias = new ArrayList<Categoria>(); 
        try{
            categorias = serviciosEscuela.consultarCategoriasMasBuscadas();
        }catch(ExcepcionServiciosEscuela e){
            e.printStackTrace();
        }
        return categorias;
    }
    
    /**
     * Se encarga de conectar el boton de "CREAR CATEGORIA" del frontend con el m??todo crear categoria
     * implementado en los servicios de la escuela
     */
    public void agregarCategoria(){
        try{
            serviciosEscuela.crearCategoria(nombreCategoria, descripcionCategoria);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    /**
     * Metodo que se encarga de modificar la categoria de acuerdo a los nuevos parametros
     * dados por el usuario
     */
    public void actualizarCategoria(){
        try{
            if(!revisionNombre()){
                serviciosEscuela.actualizarCategoria(nombreCategoria, nombreActualizar, descripcionActualizar, estadoActualizar);
            }
            else{
                JOptionPane.showMessageDialog(null, "No se puede repetir nombres de categorias");
            }
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Metodo que se encarga de eliminar la categoria que el cliente desee.
     * Este proceso se logra gracias al nombre de la categoria a eliminar
     */
    public void eliminarCategoria(){
        try{
            serviciosEscuela.eliminarCategoria(nombreCategoria);
            this.nombres.clear();
            init();
        }
        catch(Exception exception){}
        
    }
    
    /**
     * Debido a que primero se busca la categoria a la cual se le quiere actualizar
     * apenas tengamos la que queremos, nos dirigimos a la actualizacion final
     * que es donde esta la informacion de esta categoria
     */
    public void redireccionarActualizacion(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../admin/modificacionFinal.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Ya modificada la categoria, nos devolvemos a la busqueda de las categorias
     * que se encuentran en la base para ver si el cliente quiere modificar otra
     */
    public void redireccionAnterior(){
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../admin/modificarCategoria.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Apenas haga el proceso que necesitaba el cliente, se le dirige a la pagina principal
     * del administador
     */
    public void redireccionPrincipal(){
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../roles/administrador.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Como primero se busca la categoria que se quiera eliminar, se redirecciona a 
     * una pagina donde se da los valores de la categoria buscada.
     */
    public void redireccionarEliminacion(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../admin/eliminacionFinal.xhtml");
        }
        catch(Exception exception){}
    }
    
    /**
     * Funcion que revisa si el nombre que se le quiere poner como actulizacion a la categoria
     * esta dentro del arreglo de nombres de categorias.
     * @return -> boolean 
     */
    public boolean revisionNombre(){
        boolean valor = true;
        for(String nombre : this.nombres){
            if(nombre.equals(this.nombreActualizar)){
                valor = false;
            }
        }
        return valor;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    

    public List<String> getNombres() {
        this.nombres.clear();
        init();
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getNombreActualizar() {
        return nombreActualizar;
    }

    public void setNombreActualizar(String nombreActualizar) {
        this.nombreActualizar = nombreActualizar;
    }

    public String getDescripcionActualizar() {
        return descripcionActualizar;
    }

    public void setDescripcionActualizar(String descripcionActualizar) {
        this.descripcionActualizar = descripcionActualizar;
    }

    public String getEstadoActualizar() {
        return estadoActualizar;
    }

    public void setEstadoActualizar(String estadoActualizar) {
        this.estadoActualizar = estadoActualizar;
    }

    public ServiciosEscuela getServiciosEscuela() {
        return serviciosEscuela;
    }

    public void setServiciosEscuela(ServiciosEscuela serviciosEscuela) {
        this.serviciosEscuela = serviciosEscuela;
    }

    public DonutChartModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }

    public HashMap<String, Number> getValoresGrafico() {
        return valoresGrafico;
    }

    public void setValoresGrafico(HashMap<String, Number> valoresGrafico) {
        this.valoresGrafico = valoresGrafico;
    }
    
    
    
    

    

    
    
}
