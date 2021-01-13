CREATE PRIMARY INDEX ON `beer-sample` USING GSI;
DROP PRIMARY INDEX ON CouchBase;

CREATE INDEX productName_index1 ON bucket_name(productName, ProductID)
WHERE type="product" USING GSI;
CREATE INDEX ind ON CouchBase(id) USING GSI;