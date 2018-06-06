package xin.zachary.nffn.daoimpl;

import org.springframework.stereotype.Repository;
import xin.zachary.nffn.dao.UserMappingDAO;
import xin.zachary.nffn.entity.UserMapping;
@Repository("userMappingDAO")
public class UserMappingDAOPImpl extends BaseDAOImpl<UserMapping> implements UserMappingDAO {

}
