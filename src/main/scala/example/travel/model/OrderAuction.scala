package example.travel.model 

import net.liftweb.common.{Full,Box,Empty,Failure}
import net.liftweb.mapper._

object OrderAuction extends OrderAuction with LongKeyedMetaMapper[OrderAuction]{
  override def dbTableName = "order_auctions"
}

class OrderAuction extends LongKeyedMapper[OrderAuction] 
  with IdPK with CreatedUpdated {
  def getSingleton = OrderAuction
  // fields
  object name extends MappedString(this, 150)
  
  // relationships
  object order extends  MappedLongForeignKey(this, Order){
    override def dbColumnName = "order_id"
  }
}
