package iebem.edu.mx.timbre_normales.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import iebem.edu.mx.timbre_normales.model.XmlModel;
@Component
public class ConsultaInfo implements RowMapper<XmlModel> {

    @Override
    public XmlModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        XmlModel xml = new XmlModel();
        xml.setCadena_original(rs.getString("firma"));
        xml.setFecha_exp(rs.getString("fecha_exp"));
        xml.setIdAlumno(rs.getInt("idAlumno"));
        return xml;
       
    }
    
}
