<?xml version="1.0" encoding="UTF-8"?><model xmlns="http://www.justep.com/model"><action xmlns="" name="findHotGoodsDatas" impl="fruitstore.Index.findHotGoodsDatas"/><action xmlns="" name="queryFS_GOODS" impl="action:common/CRUD/query"><private xmlns="" name="condition" type="String"/><private xmlns="" name="db" type="String">FruitStore</private><private xmlns="" name="tableName" type="String">FS_GOODS</private><public xmlns="" name="columns" type="Object"/><public xmlns="" name="filter" type="String"/><public xmlns="" name="limit" type="Integer"/><public xmlns="" name="offset" type="Integer"/><public xmlns="" name="orderBy" type="String"/><public xmlns="" name="variables" type="Object"/></action><action xmlns="" name="saveFS_GOODS" impl="action:common/CRUD/save"><private xmlns="" name="db" type="String">FruitStore</private><private xmlns="" name="permissions" type="Object"><![CDATA[{"FS_GOODS":""}]]></private><public xmlns="" name="tables" type="List"/></action></model>