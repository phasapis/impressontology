###### Change Log

###### 2 February 2016

- Major clean up of ontology
- Removed all old imports, as they were introducing a lot of unecessary properties and classes
- Imported (with owl:import) models that are of great usage to us as a whole:
 - Added spatial attributes into the ontology by importing WGS84 Geo Positioning (geo)
 - Added by data authorization facet/module by importing PPO ontology
 - Added ontology author description etc
- Added temporal aspects to the ontology by adding one new class (Timeslice) and a new object property (hasTimeslice)

###### 12 February 2016

- Matched Building and Spatial Thing by equivalent class
- Imported weather ontology from local file. Local file was copied from https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl 
 BUT removed all unnecessary object and datatype properties (namely, those that had to do with time)
- Major refector of the structure: Person, Activity and Resource are separate files now tha are imported from the main ontology
- Removed DUL and Model ontologies
- Removed PPO ontology as obsolete
- Created version 0.4 of deliverable

###### Next steps

- add more properties and classes associated with EDXL
- need to add properties for data access (apart from roles coming from WAI)
