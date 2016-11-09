package com.zulu.idits.modelo;


public class Usuario {

    private String nombre, apellido, cuil, email, provincia, fechaDeNacimiento;
    private int dni, codigoPostal;
    private boolean realizaAportes;
    private int telefono;

    public Usuario() {

    }


    public Usuario(int dni, String nombre, String apellido, String cuil, String email, String provincia, String fechaDeNacimiento, int telefono, int codigoPostal, boolean realizaAportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.email = email;
        this.provincia = provincia;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.dni = dni;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.realizaAportes = realizaAportes;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public boolean realizaAportes() {
        return realizaAportes;
    }

    public void setRealizaAportes(boolean realizaAportes) {
        this.realizaAportes = realizaAportes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", cuil='").append(cuil).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", provincia='").append(provincia).append('\'');
        sb.append(", fechaDeNacimiento='").append(fechaDeNacimiento).append('\'');
        sb.append(", dni=").append(dni).append('\'');
        sb.append(", telefono=").append(telefono).append('\'');
        sb.append(", codigoPostal=").append(codigoPostal).append('\'');
        sb.append(", realizaAportes=").append(realizaAportes);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (dni != usuario.dni) return false;
        if (telefono != usuario.telefono) return false;
        if (codigoPostal != usuario.codigoPostal) return false;
        if (realizaAportes != usuario.realizaAportes) return false;
        if (!nombre.equals(usuario.nombre)) return false;
        if (!apellido.equals(usuario.apellido)) return false;
        if (cuil != null ? !cuil.equals(usuario.cuil) : usuario.cuil != null) return false;
        if (!email.equals(usuario.email)) return false;
        if (provincia != null ? !provincia.equals(usuario.provincia) : usuario.provincia != null)
            return false;
        return fechaDeNacimiento.equals(usuario.fechaDeNacimiento);

    }

    @Override
    public int hashCode() {
        return dni;
    }
}
