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

###### 23 February 2016

- fixed older skos files
- added new missing skos for physiological lesions
- made Triage into skos
- removed obsolete classes
- added and fixed weather ontology to match better WARSYS
- edxl have addition (partially only stuff we needed now)

###### 5 May 2016

- fixed typos
- added codelists related to Palermo demo (agencies and public buildings)
- added temporal aspect
- added roles

###### Next steps

- TSO codes
- add categories of vehicles, hospitals from pilots (allegedly to be provided in a few days)
- WHO classification

