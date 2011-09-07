dataSource {
	pooled = true
	logSql = false
}

hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
development {
	dataSource {
		username = "pagos"
		password = "pagos"
		dbCreate = "update" // one of 'create', 'create-drop','update'
		url = "jdbc:mysql://localhost:3306/pagos" //"jdbc:hsqldb:mem:devDB"
		driverClassName = "org.gjt.mm.mysql.Driver"
		properties {
			maxActive = 50
			maxIdle = 25
			minIdle = 5
			initialSize = 5
			minEvictableIdleTimeMillis = 60000
			timeBetweenEvictionRunsMillis = 60000
			maxWait = 10000
			validationQuery = "select 1 from dual"
		}
	}
}

test {
	dataSource {
		dbCreate = "update"
		url = "jdbc:hsqldb:mem:testDb"
	}
}

production {
	dataSource {
		username = "pse_prod"
		password = "fersca"
		dbCreate = "update" // one of 'create', 'create-drop','update'
		url = "jdbc:mysql://localhost:3306/pse" //"jdbc:hsqldb:mem:devDB"
		driverClassName = "org.gjt.mm.mysql.Driver"
		properties {
			maxActive = 50
			maxIdle = 25
			minIdle = 5
			initialSize = 5
			minEvictableIdleTimeMillis = 60000
			timeBetweenEvictionRunsMillis = 60000
			maxWait = 10000
			validationQuery = "select 1 from dual"
		}
	}
}
}	