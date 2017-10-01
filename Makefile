run: build
	@echo Running...
	@cd src && java value.App ../sitedata.txt ../customerdata.txt
.PHONY: run

build:
	@echo Building...
	@javac src/value/*.java
	@echo Build complete.
.PHONY: build
