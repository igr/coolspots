package ac.obl.coolspots.omaps

import ac.obl.coolspots.db.Destination

class KmlDocument(
    val destination: Destination,
    placemarks: List<KmlPlacemark>
) {

    private val placemarkText = placemarks.joinToString(separator = "\n") { it.get() }

    fun get() = """
<?xml version="1.0" encoding="UTF-8"?>
<kml xmlns="http://earth.google.com/kml/2.2">
<Document>
  <Style id="placemark-red">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-red.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-blue">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-blue.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-purple">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-purple.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-yellow">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-yellow.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-pink">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-pink.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-brown">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-brown.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-green">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-green.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-orange">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-orange.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-deeppurple">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-deeppurple.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-lightblue">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-lightblue.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-cyan">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-cyan.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-teal">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-teal.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-lime">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-lime.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-deeporange">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-deeporange.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-gray">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-gray.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <Style id="placemark-bluegray">
    <IconStyle>
      <Icon>
        <href>https://omaps.app/placemarks/placemark-bluegray.png</href>
      </Icon>
    </IconStyle>
  </Style>
  <name>Cool Spots: ${destination.name}</name>
  <visibility>1</visibility>
  <ExtendedData xmlns:mwm="https://omaps.app">
    <mwm:name>
      <mwm:lang code="default">${destination.name}</mwm:lang>
    </mwm:name>
    <mwm:annotation>
    </mwm:annotation>
    <mwm:description>${destination.name}, ${destination.countryName}
    </mwm:description>
    <mwm:lastModified>2022-01-20T00:00:16Z</mwm:lastModified>
    <mwm:accessRules>Local</mwm:accessRules>
  </ExtendedData>
  $placemarkText
</Document>
</kml>
""".trimIndent()

}
